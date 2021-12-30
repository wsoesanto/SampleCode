// import React from 'react';
// import {render} from 'react-dom';
import { SayHelloRequest, SayHelloResponse } from 'SampleCode/hermes/example/hello_world_service_pb';
import {HelloWorldServicePromiseClient} from 'SampleCode/hermes/example/hello_world_service_grpc_web_pb';

// render(<html />, document.getElementById('root'));

let client = new  HelloWorldServicePromiseClient("http://localhost:10000/");
let req = new SayHelloRequest();
let res = client.sayHello(req);
// res.then(val: SayHelloResponse => {
//     console.log(val);
// });