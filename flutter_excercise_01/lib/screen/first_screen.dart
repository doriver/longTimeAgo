import 'package:flutter/material.dart';
import 'package:flutter_excercise_01/screen/manager/screen_manager.dart';
import 'package:flutter_excercise_01/screen/second_screen.dart';

class FirstScreen extends StatefulWidget {
  static String screenName = "FirstScreen";

  const FirstScreen({super.key});

  @override
  State<FirstScreen> createState() => _FirstScreenState();
}

class _FirstScreenState extends State<FirstScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar( title: Text('123First Screen') ),
      body: ElevatedButton( 
        onPressed: () {
          ScreenManager.openScreen(SecondScreen.screenName);
        }, 
        child: Text('Go to Second Screen')),
    );
  }
}