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
        appBar: AppBar( backgroundColor:Colors.blue ),
        body: MyWidget() 
      )
    );
  }
}
// 단축키 : stless + tab키  >>>  아래 커스텀위젯 기본 세팅 생김
class MyWidget extends StatelessWidget { // 커스텀 위젯이 되려면 class안에 변수, 함수 많이 넣어야하고 그래서 extends StatelessWidget을 해주는거
  const MyWidget({super.key}); // class 에 어떤 파라미터 넣을수 있는지 정의 부분

  @override
  Widget build(BuildContext context) {
    return SizedBox(
          child: Text('data'),
        );
  }
}  