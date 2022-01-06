import path from 'path';
import * as webpack from 'webpack';
import {runfiles} from '@bazel/runfiles';
import * as fs from 'fs/promises';


let ans = path.resolve(process.cwd(), 'bazel-out/darwin-fastbuild/bin');

const config: webpack.Configuration = {
  mode: 'development',
  resolve: {
      alias: {
        SampleCode: ans,
      },
      preferAbsolute: true,
  }
};

// console.log('gilayalu');
console.log(ans);

export default config