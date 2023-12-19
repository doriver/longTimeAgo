import 'package:flutter/material.dart';
import 'package:shopping_mall/common/bar.dart';

class StoreListPage extends StatelessWidget {
  StoreListPage({super.key});

  final List<String> storeList = ['여의도', '김포', '부산'];
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: Bar.topIcon('매장목록'),
      body: Container(
        padding: EdgeInsets.all(30),
        child: GridView.builder(
          gridDelegate: const SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 2, // 열의 수      
            mainAxisSpacing: 20.0, // 주 축(수직 방향) 간격
            crossAxisSpacing: 20.0, // 크로스 축(수평 방향) 간격
            childAspectRatio: 1.0, // 각 그리드 항목의 가로/세로 비율
          ),
          itemCount: storeList.length, 
          itemBuilder: (context, index){
            return Stack(
              children: [
                Positioned(
                  child: Container(
                    width: double.infinity,
                    height: double.infinity,
                    padding: EdgeInsets.all(30),
                    color: Colors.yellow,
                    child: Text(storeList[index])
                  )
                ),
                Positioned(
                  left: 30,
                  top: 100,
                  child: Container(
                    width: 50, height: 50,
                    padding: EdgeInsets.all(10),
                    color: Colors.blue,
                    child: Text(
                      index.toString(),
                      style: TextStyle(color: Colors.white))
                  )
                )
              ]
            );
          }),
      ),
      bottomNavigationBar: BottomAppBar(child: Bar.buttomIcon)
    );
  }
}