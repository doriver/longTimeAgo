import 'package:flutter/material.dart';
import 'package:flutter_excercise_01/pages/form_screen.dart';
import 'package:flutter_excercise_01/pages/main_page.dart';
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
    return MaterialApp(
      home: FormScreen(title: 'title')
      // MainPage()
    );
  }
}