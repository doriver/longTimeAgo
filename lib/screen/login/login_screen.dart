import 'package:flutter/material.dart';
import 'package:flutter_excercise_01/common/constants.dart';
import 'package:flutter_excercise_01/screen/first_screen.dart';
import 'package:flutter_excercise_01/screen/manager/screen_manager.dart';

class LoginScreen extends StatefulWidget {
  static String screenName = "LoginScreen";

  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();  
}

class _LoginScreenState extends State<LoginScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: kLoginScaffoldKey,
      appBar: AppBar( title: Text('login Screen') ),
      body: ElevatedButton( 
        onPressed: () {
          ScreenManager.openScreen(FirstScreen.screenName);
        }, 
        child: Text('Go to First Screen')),
    );
  }

}