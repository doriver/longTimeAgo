import 'package:flutter/material.dart';
import 'package:flutter_ui_excercise01/columnRow.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter ui',
      home: ColumnRow()
    );
  }
}
