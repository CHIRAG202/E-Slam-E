/* Created by Manjeet Singh
 17 Oct'17
 */
 var gzippo = require('gzippo');
  

var express = require('express'),
  app = express(),
  port = 8080,
  mongoose = require('mongoose'),
  Friend = require('./api/models/friendModels'), //created model loading here
  bodyParser = require('body-parser');
  app.use(express.static(__dirname));
  app.get('/', function(req, res) {
    res.sendfile('test.html', {root: __dirname })
});
  app.get('/', function(req, res) {
    res.sendfile('add.html', {root: __dirname })
});
  app.get('/welcome', function(req, res) {
    res.sendfile('start.html', {root: __dirname })
});
    app.get('/', function(req, res) {
    res.sendfile('start.html', {root: __dirname })
});
    app.get('/', function(req, res) {
    res.sendfile('getinitial.html', {root: __dirname })
});
  
   app.get('/', function(req, res) {
    res.sendfile('fullinfo.html', {root: __dirname })
});
// mongoose instance connection url connection
// mongodb://localhost/frienddb
mongoose.Promise = global.Promise;
mongoose.connect('mongodb://manjeet_04:Manjeet04@ds139984.mlab.com:39984/friend',{
  useMongoClient: true,
  // other options */
}); 

//mongoose.connect('mongodb://<dbuser>:<dbpassword>@ds139984.mlab.com:39984/friend').exec()
  //  .then(() => { // if all is ok we will be here
    //    return server.start();
   // })
  //  .catch(err => { // if error we will be here
    //    console.error('App starting error:', err.stack);
      //  process.exit(1);
    //});

app.use(bodyParser.raw({ extended: true }));
app.use(bodyParser.json());
//app.use(function(req, res) {
 // res.status(404).send({url: req.originalUrl + ' not found'})
//});

var routes = require('./api/routes/friendRoutes'); //importing route
routes(app); //register the route


app.listen(process.env.PORT || 5000);


console.log('friend RESTful API server started on: ' + port);