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
        body: aaa 
      )
    );
  }
}
// 안에있는 data가 변할때는 변수에 담으면 안되고, 커스텀위젯 사용해야함
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

var aaa = SizedBox( child: Text('변수에 넣은거') );
// 변하지 않는 UI들은 변수함수로 축약해도 상관없음