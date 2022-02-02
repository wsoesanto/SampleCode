import express from 'express';
// import {ServingContext} from 'SampleCode/uix/server/example/serving_context_pb';
import {renderToString} from 'react-dom/server';
import {runfiles} from '@bazel/runfiles';
import {deps} from 'SampleCode/uix/client/deps';

function main() {
    const app = express()

    app.get('/', (req, res) => {
        res.send(renderToString(<html>
            <head></head>
            <body>
                <div>Hello World Gila!</div>
                <div id='react-dom'/>
            </body>
            <script src='https://unpkg.com/react@17/umd/react.development.js' crossOrigin='true'></script>
            <script src='https://unpkg.com/react-dom@17/umd/react-dom.development.js' crossOrigin='true'></script>
            <script type='application/javascript' src='client.js'/>
        </html>));
    });

    app.get('/client.js', (req, res) => {
        res.sendFile(process.cwd() + '/uix/client/example/app.bundle.js/main.js');
    });

    const port = 80;
    app.listen(port, () => {
        console.log(`Example app listening at http://localhost:${port}`);
    });
}

if (require.main === module) {
    main();
}
