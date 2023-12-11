import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:loader_overlay/loader_overlay.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return GlobalLoaderOverlay(
      child: GetMaterialApp(
        home: MyFirstScreen()
        // Text('hello world')
      )
    );
  }
}

class MyFirstScreen extends StatelessWidget {
  const MyFirstScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar( title: Text('First Screen') ),
      body: ElevatedButton( 
        onPressed: () {
          Navigator.push(
            context, 
            MaterialPageRoute(builder: (context) => MySecondScreen())
          );
        }, 
        child: Text('Go to Second Screen')),
    );
  }
}

class MySecondScreen extends StatelessWidget {
  const MySecondScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar( title: Text('Second Screen') ),
      body: ElevatedButton(
        onPressed: () {},
        child: Text('Go Back to First Screen'))
    );
  }
}