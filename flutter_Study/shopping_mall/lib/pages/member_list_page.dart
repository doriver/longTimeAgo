import 'package:flutter/material.dart';
import 'package:shopping_mall/common/bar.dart';

class MemberListPage extends StatelessWidget {
  MemberListPage({super.key});
  
  final List<String> member = ['깉xx', '박xx', '이xx'];
  final List<String> genders = ['남자', '여자'];
  final List<String> locations = ['서울', '뉴욕', '전라도', '경상도', '제주도', '강원도'];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: Bar.topIcon('회원목록'),
      drawer: Bar.drawer(),
      body: ListView.builder(
        itemCount: 99,
        itemBuilder: (context, index) { 
          String name = member[index % 3];
          String gender = genders[index % 2];
          String location = locations[index % 6];
          return ListTile(
            title: Text((index+1).toString() +'. $name' + '  /  ' + '$gender' + '  /  ' + '$location'),
            onTap: (){}
          );
        }
      ),
      bottomNavigationBar:BottomAppBar( 
        child: Bar.buttomIcon
      )
    );
  }
}