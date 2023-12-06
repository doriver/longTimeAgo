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
        body:  Align(
          alignment: Alignment.bottomLeft,
          child: Container( 
            width: 50, height: 50, color:Colors.yellow
          ),
        ),
        bottomNavigationBar: BottomAppBar( color: Colors.white, height: 60.0),
      )
    );
  }
}