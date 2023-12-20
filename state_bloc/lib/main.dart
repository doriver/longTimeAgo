import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Drawer 예제'),
        ),
        drawer: Drawer(
          // Drawer의 내용을 정의
          child: ListView(
            padding: EdgeInsets.zero,
            children: <Widget>[
              DrawerHeader(
                decoration: BoxDecoration(
                  color: Colors.blue,
                ),
                child: Text(
                  'Drawer 헤더',
                  style: TextStyle(
                    color: Colors.white,
                    fontSize: 24,
                  ),
                ),
              ),
              ListTile(
                title: Text('메뉴 항목 1'),
                onTap: () {
                  // 메뉴 항목 1을 탭했을 때 수행할 동작
                  Navigator.pop(context); // Drawer를 닫습니다.
                },
              ),
              ListTile(
                title: Text('메뉴 항목 2'),
                onTap: () {
                  // 메뉴 항목 2을 탭했을 때 수행할 동작
                  Navigator.pop(context); // Drawer를 닫습니다.
                },
              ),
            ],
          ),
        ),
        body: Center(
          child: Text('메인 내용'),
        ),
      ),
    );
  }
}