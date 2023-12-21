import 'package:flutter/material.dart';

class PopUp {

  // 팝업기능이 있는 버튼
  static ElevatedButton popButton(BuildContext context, String buttonName) {
    return ElevatedButton(
          onPressed: () {
            openPop(context);
          },
          child: Text(buttonName)
    );
  }

  // 팝업 띄우는 함수
  static void openPop(BuildContext context) {
    // 새로운 창(다이얼로그)이 화면에 나타난다.
    showDialog( 
      context: context, // 다이얼로그가 어느 위치에서 호출되었는지를 나타낸다.
      builder: (BuildContext context) { // 다이얼로그의 내용을 생성하는 콜백 함수
        return AlertDialog(
          title: Text('title'),
          content: Text('content'),
          actions: [
            TextButton(
              onPressed: () { },
              child: Text('actions'),
            ),
            TextButton(
              onPressed: () {
                Navigator.of(context).pop();
              },
              child: Text('닫기'),
            )
          ],
        );
      }
    );
  }
}