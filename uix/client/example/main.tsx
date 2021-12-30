// import React from 'react';
// import {render} from 'react-dom';
import { SayHelloRequest, SayHelloResponse } from 'SampleCode/hermes/example/hello_world_service_pb';
import {HelloWorldServicePromiseClient} from 'SampleCode/hermes/example/hello_world_service_grpc_web_pb';

// render(<html />, document.getElementById('root'));

async function main() {
    let client = new  HelloWorldServicePromiseClient("http://127.0.0.1:8080");
    let req = new SayHelloRequest();
    
    try {
        await client.sayHello(req);
        console.log('gila ya');
    } catch (e: any) {
        console.log('nyebelin');
        console.log(e);
    }
}

if (require.main === module) {
    main();
}