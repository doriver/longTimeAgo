import 'package:flutter/material.dart';

class ViewChangeButton extends StatefulWidget {
  final Function(String) click;

  const ViewChangeButton({super.key, required this.click});

  @override
  State<ViewChangeButton> createState() => _ViewChangeButtonState();
}

class _ViewChangeButtonState extends State<ViewChangeButton> {
  String viewStyle = 'grid';

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: EdgeInsets.all(5),
      child: Row(
        children: [
          ElevatedButton(
            onPressed: () {
              viewStyle = 'grid';
              widget.click(viewStyle);
              print("viewStyle =  $viewStyle");
            },
            style: ElevatedButton.styleFrom(
              backgroundColor: viewStyle == 'grid' ? Colors.amber.shade100 : Colors.blueGrey.shade100
            ),
            child: Text('그리드 뷰')
          ),
          SizedBox(width: 5),
          ElevatedButton(
            onPressed: () {
              viewStyle = 'list';
              widget.click(viewStyle);
              print("viewStyle =  $viewStyle");
            },
            style: ElevatedButton.styleFrom(
              backgroundColor: viewStyle == 'grid' ? Colors.blueGrey.shade100 : Colors.amber.shade100 
            ),
            child: Text('리스트 뷰')
          )
        ]
      ),
    );
  }
}