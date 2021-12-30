import * as webpack from 'webpack';

const config: webpack.Configuration = {
  mode: 'development',
  resolve: {
      preferRelative: false,
      roots: []
  }
};

console.log('logilaya');
console.log(__dirname);

export default config;
