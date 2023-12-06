import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {

    return MaterialApp(
      home: Scaffold(
        appBar: AppBar( backgroundColor: Colors.blue, title: Text('My Flutter App') ),
        body:  Container( 
          width: 50, height: 50, 
          margin: EdgeInsets.fromLTRB(5, 10, 15, 20),
          padding: EdgeInsets.all(5),
          decoration: BoxDecoration(
            color:Colors.yellow,
            border: Border.all(color: Colors.black)
          ),
          child: Text('dddddddddd')
        ),
        bottomNavigationBar: BottomAppBar( color: Colors.white, height: 60.0),
      )
    );
  }
}