const express = require('express');
//const http = require('http');
var request = require('request')
const basic = require('basic-authorization-header');
const path = require("path");

const filePath = path.resolve(__dirname, 'index.html');

var username = 'user';
var password = 'user';
var options = {
  url: 'http://localhost:8000/tasks',
  headers: {
    'Authorization': basic(username, password)
  }
};

const app = express();
const PORT = 1100;

app.listen(PORT, () => console.log(`app is started on ${PORT}`));

app.get("/tasks", (req, res) => {
  console.log("Hello, my first Node.js app is running");

  request(options, function (err, resp, body) {
    if (err) {
      console.dir(err)
      return;
    }
    // parse method is optional
    //return res.status(200).send(JSON.parse(body));
    res.sendFile(filePath);
  });

    
});