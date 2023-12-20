import 'package:flutter/material.dart';

class ViewChangeButton extends StatefulWidget {
  final Function(bool) onToggle;

  const ViewChangeButton({super.key, required this.onToggle});

  @override
  State<ViewChangeButton> createState() => _ViewChangeButtonState();
}

class _ViewChangeButtonState extends State<ViewChangeButton> {
  bool isTogglePressed = true;
  
  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        ElevatedButton(
          child: Text('그리드 뷰'),
          onPressed: () {
            
          },
        ),
        ElevatedButton(
          child: Text('리스트 뷰'),
          onPressed: () {
            
          },
        )
      ]
    );
  }
}