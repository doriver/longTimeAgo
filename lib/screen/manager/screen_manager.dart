import 'package:flutter/material.dart';
import 'package:flutter_excercise_01/common/constants.dart';
import 'package:flutter_excercise_01/screen/first_screen.dart';
import 'package:flutter_excercise_01/screen/login/login_screen.dart';
import 'package:flutter_excercise_01/screen/second_screen.dart';

Map<String, dynamic> kScreenMap = {
  LoginScreen.screenName: const LoginScreen(),
  FirstScreen.screenName: const FirstScreen(),
  SecondScreen.screenName: const SecondScreen()
};

class ScreenManager {
  static BuildContext? get context => kLoginScaffoldKey.currentContext;// context는 BuildContext를 반환하는 getter       

  static void openScreen(String screenName) {
    var screen = kScreenMap[screenName];
    BuildContext context = ScreenManager.context!;
    Navigator.of(context).push( // 왜 맨 첫화면 context를 가져다가 고정해논지는 모름
      MaterialPageRoute(
        builder: (context) => screen,
      ),
    );
  } 

  static void closeScreen() {
    Navigator.of(ScreenManager.context!).pop();
  }
}