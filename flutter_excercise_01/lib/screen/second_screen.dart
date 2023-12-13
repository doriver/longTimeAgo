import 'package:flutter/material.dart';
import 'package:flutter_excercise_01/screen/manager/screen_manager.dart';

class SecondScreen extends StatefulWidget {
  static String screenName = "SecondScreen";

  const SecondScreen({super.key});

  @override
  State<StatefulWidget> createState() => _SecondScreenState();
}

class _SecondScreenState extends State<SecondScreen> {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      appBar: AppBar( title: Text('123Second Screen') ),
      body: ElevatedButton(
        onPressed: () {
          ScreenManager.closeScreen();
        },
        child: Text('Go Back to First Screen'))
    );
  }

}