import path from 'path';
import * as webpack from 'webpack';
import {runfiles} from '@bazel/runfiles';

let ans = path.resolve(process.cwd(), 'bazel-bin');
console.log(runfiles.resolveWorkspaceRelative('hermes/example/hello_world_service_pb.js'));

const config: webpack.Configuration = {
  mode: 'development',
  resolve: {
      alias: {
        SampleCode: ans,
      },
      preferAbsolute: true,
  }
};

console.log('gilayalu');
console.log(ans);

export default config