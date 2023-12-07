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
        appBar: AppBar( title: Text('금호동3가'), actions: [Icon(Icons.search), Icon(Icons.menu), Icon(Icons.notifications)], ),
        body: 
        Container(
          child: Row(
            children: [
              Container(
                height: 150,
                width: 100,
                margin: EdgeInsets.fromLTRB(10, 5, 0, 5),
                child: Image.asset('assets/image.png') 
              ),
              Container(
                height: 150,
                width: 200,
                margin: EdgeInsets.all(20),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text('캐논 DSLR 100D(단렌즈, 충전기 16기가SD 포함)'),
                    Text('끌올 10분전'),
                    Text('100,000원'),
                    Icon(Icons.heart_broken)
                  ]
                ),
              )
            ]
          )
        )
      )
    );
  }
}