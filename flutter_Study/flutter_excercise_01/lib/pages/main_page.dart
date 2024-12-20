import 'package:flutter/material.dart';
import 'package:flutter_excercise_01/common/pop_up.dart';

class MainPage extends StatelessWidget {
  const MainPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Column(
        children: [
          PopUp.popButton(context, '팝업버튼')
        ]
      )
    );
  }
}



