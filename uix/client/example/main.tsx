// import React from 'react';
// import {render} from 'react-dom';
import { SayHelloRequest, SayHelloResponse } from 'SampleCode/hermes/example/hello_world_service_pb';
import {HelloWorldServicePromiseClient} from 'SampleCode/hermes/example/hello_world_service_grpc_web_pb';

// render(<html />, document.getElementById('root'));

async function main() {
    let client = new  HelloWorldServicePromiseClient("http://127.0.0.1:8080");
    let req = new SayHelloRequest();
    
    try {
        let res =  await client.sayHello(req);
    } catch (e: any) {
        console.log(e.message);
    }
}

if (require.main === module) {

    performance.mark('a');
    Promise.all([...Array(1000).keys()].map(x => {
        return main();
    })).then(value => {
        performance.mark('b');
        let measurement = performance.measure('measure', 'a', 'b');
        console.log(measurement);
    });
}