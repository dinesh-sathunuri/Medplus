const express=require("express");
var url = require('url');
var add=require('./add');
const port=8000;
const app=express();
var previous;
app.get("/inputelements",(req,res)=>{
    var q = url.parse(req.url, true);
    res.write('<p>'+q.pathname+'</p>');
    previous = q.pathname;
res.write('<form action="/add">');
res.write('<input name="firstelement" type="text"></br></br>');
res.write('<input name="secondelement" type="text"></br></br>');
res.write('<input type="submit">');
res.write('</form>');
res.end();
});
app.get("/add",(req,res)=>{
    res.writeHead(200, {'Content-Type': 'text/html'});

    var q = url.parse(req.url, true);
    previous=previous+q.pathname;
    res.write('<p>'+previous+'</p>');
    var q = url.parse(req.url, true).query;
    var a=parseInt(q.firstelement);
    var b=parseInt(q.secondelement);
    var c=add.adding(a,b);
    res.write('<form action="/factorial">');
    res.write('<input type="text" name="factorial" value='+c+'>');
    res.write('<input type="submit">');
    res.end('</form>')
});
app.get("/factorial",(req,res)=>{
    res.writeHead(200, {'Content-Type': 'text/html'});
    var q = url.parse(req.url, true);
    previous=previous+q.pathname;
    res.write('<p>'+previous+'</p>');
    var q = url.parse(req.url, true).query;
    var f=parseInt(q.factorial);
    res.write(add.factorial(f).toString());
   res.end();
});
app.listen(port,()=>{
    console.log("server has started");
})