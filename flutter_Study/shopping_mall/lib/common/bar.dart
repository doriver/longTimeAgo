import 'package:flutter/material.dart';
import 'package:get/get.dart';

class Bar {
  static var buttomIcon = Row(
    mainAxisAlignment: MainAxisAlignment.spaceEvenly,
    children: [
      IconButton(
        onPressed: (){
          Get.back();
        }, 
        icon: Icon(Icons.arrow_back)
      ),
      Icon(Icons.accessibility_outlined),
      Icon(Icons.add_alert_rounded)
    ]
  );

  static AppBar topIcon(String title) {
     return AppBar(title: Text("$title"), backgroundColor: Colors.green);
  }  // leading: Icon(Icons.ad_units), 리딩이 있으면 drawer 안먹히는듯

  static Drawer drawer() {
    return Drawer(
      child: ListView(
        children: [
          DrawerHeader(
            decoration: BoxDecoration(
              color: Colors.green,
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
            
            },
          ),
          ListTile(
            title: Text('메뉴 항목 2'),
            onTap: () {
              // 메뉴 항목 2을 탭했을 때 수행할 동작
              
            },
          ),
        ]
      )
    );
  }
}