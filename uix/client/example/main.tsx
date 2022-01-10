// import React from 'react';
// import {render} from 'react-dom';
import { SayHelloRequest, SayHelloResponse } from 'SampleCode/hermes/example/hello_world_service_pb';
import {HelloWorldServicePromiseClient} from 'SampleCode/hermes/example/hello_world_service_grpc_web_pb';
import {context, Span, SpanStatusCode, SpanKind, trace} from '@opentelemetry/api'
import { ZoneContextManager } from '@opentelemetry/context-zone';
import {WebTracerProvider} from '@opentelemetry/sdk-trace-web'
import { ConsoleSpanExporter, SimpleSpanProcessor, Tracer} from '@opentelemetry/sdk-trace-base';
import { render } from 'react-dom';
import { registerInstrumentations } from '@opentelemetry/instrumentation';
import { GrpcInstrumentation } from '@opentelemetry/instrumentation-grpc';

async function start<T>(span: Span, fn: (span: Span) => Promise<T>): Promise<T> {
    try {
        return await fn(span);
    } catch (err) {
        span.setStatus({
            code: SpanStatusCode.ERROR,
            message: err.toString()
        });
        throw err;
    } finally {
        span.end();
    }
}

class MyTracer {

    readonly tracer: Tracer;

    public constructor(tracer: Tracer) {
        this.tracer = tracer;
    }

    public root<T>(name: string, spanKind: SpanKind, fn: (span: Span) => Promise<T>): Promise<T> {
        return this.tracer.startActiveSpan(name, {kind: spanKind, root: true}, (span) => start(span, fn));
    }

    public listen<T>(name: string, fn: (span: Span) => Promise<T>): Promise<T> {
        return this.root(name, SpanKind.CONSUMER, fn);
    }

    public span<T>(name: string, fn: (span: Span) => Promise<T>): Promise<T> {
        return this.tracer.startActiveSpan(name, {}, (span) => start(span, fn));
    }

    public dispatch<T>(name: string, fn: (span: Span) => Promise<T>): Promise<T> {
        return this.tracer.startActiveSpan(name, {kind: SpanKind.CLIENT}, (span) => start(span, fn));
    }
}

const provider  = new WebTracerProvider();
provider.addSpanProcessor(new SimpleSpanProcessor(new ConsoleSpanExporter()));
provider.register({
    contextManager: new ZoneContextManager()
});
registerInstrumentations({
    instrumentations: [new GrpcInstrumentation()]
});

const tracer = new MyTracer(provider.getTracer('elfin'));

function makeRpcCall() {
    let client = new  HelloWorldServicePromiseClient("http://127.0.0.1:8080");
    let req = new SayHelloRequest();
    
    try {
        return tracer.dispatch('/hermes.example.HelloWorldService/SayHello', _ => {
            return client.sayHello(req);
        });
    } catch (e: any) {
        console.log(e.message);
    }
}

function setUpButton() {
    render(<button type='button' onClick={ (e) => tracer.listen('ButtonClick', async _ => {
        performance.mark('a');
        let response = await makeRpcCall();
        performance.mark('b');
        let measurement = performance.measure('measure', 'a', 'b');
        console.log(measurement.duration);
    })}>Button</button>, document.getElementById('react-dom'));
}

if (require.main === module) {
    tracer.root('InitialRendering', SpanKind.INTERNAL, async _ => {
        setUpButton();
    });
}
// const webTracerWithZone = new WebTracerProvider().getTracer('default');

// const rootSpan = webTracerWithZone.startSpan('rootSpan');

// context.with(trace.setSpan(context.active(), rootSpan), () => {
//   if (
//     trace.getSpan(context.active()) === rootSpan)
//     console.log('Current span is rootSpan');
//     else
//     console.log('ga bisa jir');
// });