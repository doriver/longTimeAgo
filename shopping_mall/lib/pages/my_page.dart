import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:shopping_mall/common/bar.dart';
import 'package:shopping_mall/models/User.dart';

class MyPage extends StatefulWidget {
  const MyPage({super.key});

  @override
  State<MyPage> createState() => _MyPageState();
}

class _MyPageState extends State<MyPage> {
  User? myInfo;

  @override
  void initState() {
    // initState에서 초기화 로직을 작성합니다.
    super.initState();
    
    // 여기서 상태 변수 초기화 등을 수행할 수 있습니다.
    getUserInfo();
  }

  void getUserInfo() async {
    String jsonString = await rootBundle.loadString("assets/json/user_json.json"); // json파일에서 json을 string 형태로 받아옴

    Map<String, dynamic> mapData = json.decode(jsonString); // jsonString 을 Map 형태로
    User user = User.genByMap(mapData);
    setState(() {
      myInfo = user;
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: Bar.topIcon('마이페이지'),
      body: myInfo == null ? Text("myInfo is null !!")
          : Container(
                width: double.infinity,
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Text("json데이터, initState() 를 활용"),
                    const SizedBox(height: 20),
                    SizedBox( 
                      width: 200, height: 200, 
                      child: Image.asset(
                        myInfo?.profileImagePath ?? "",
                        fit: BoxFit.cover
                      )
                    ),
                    const SizedBox(height: 20),
                    Text(
                      myInfo?.name?? "",
                      style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold)
                    ),
                    const SizedBox(height: 10),
                    Text("${myInfo?.age} 세")  
                  ]
                ),
            )
      ,
      bottomNavigationBar: BottomAppBar(child: Bar.buttomIcon)
    );
  }
}