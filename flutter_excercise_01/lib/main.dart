import 'package:flutter/material.dart';
import 'package:flutter_excercise_01/screen/login/login_screen.dart';
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
        home: LoginScreen()
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
          Navigator.push( // Navigator.push를 사용하여 두 번째 화면으로 전환
            context, 
            MaterialPageRoute(builder: (context) => MySecondScreen())
          ); // MaterialPageRoute 클래스: 화면 전환에 사용되는 표준 페이지 전환을 제공하는 클래스
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
        onPressed: () {
          Navigator.pop(context); // Navigator.pop을 사용하여 현재 화면을 닫고 이전 화면으로 돌아감
        },
        child: Text('Go Back to First Screen'))
    );
  }
}