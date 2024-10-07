const express = require('express');
const https = require("https");  
const basic = require('basic-authorization-header');

const app = express();

const PORT = 1100;

app.listen(PORT, () => console.log("app is started on 9000" ) );

app.get("/", (req, res)=>{
    console.log("Hello my first node js app is running");
   res.send("Hello bro");
});

