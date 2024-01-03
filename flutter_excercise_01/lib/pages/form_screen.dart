import 'package:flutter/material.dart';
import 'package:flutter_excercise_01/common/pop_up.dart';

class FormScreen extends StatefulWidget {
  const FormScreen({super.key, required this.title});
  final String title;

  @override
  State<FormScreen> createState() => _FormScreenState();
}

class _FormScreenState extends State<FormScreen> {

  final _formKey = GlobalKey<FormState>();
  
  String _id = '';
  String _password = '';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text(widget.title)),
      body: Form(
        key: _formKey,
        child: Container(
          width: 300,
          padding: EdgeInsets.all(20),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              TextFormField(
                decoration: InputDecoration(labelText: 'ID'),
                onSaved: (value) {
                  setState(() {
                    _id = value as String;
                  });
                },
                validator: (value) {
                  if ( value == null || value.isEmpty ) {
                    return 'please enter some text';
                  }
                  return null;
                },
                // autovalidateMode: AutovalidateMode.always
              ),
              SizedBox(height: 30),
              TextFormField(
                decoration: InputDecoration(labelText: 'PassWord'),
                onSaved: (value) {
                  setState(() {
                     _password = value as String;
                  });
                },
                validator: (value) {
                  if ( value == null || value.isEmpty ) {
                    return 'please enter some text';
                  }
                  if ( value.toString().length < 8 ) {
                    return '8자 이상 입력';
                  }
                  return null;
                },
                obscureText: true // 문자를 '*'로 표시( 비밀번호 숨김 )
                // autovalidateMode: AutovalidateMode.always
              ),
              SizedBox(height: 30),
              ElevatedButton(
                onPressed: () {
                  if (_formKey.currentState!.validate()) { // Form의 모든 TextFormField의 유효성 검사(validator)를 수행
                    _formKey.currentState!.save(); // TextFormField에 정의된 onSaved 콜백을 호출

                    // 임시로 입력값 출력되도록
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(content: Text(_id + '/' + _password)),
                    );
                  } 
                },
                child: Text('제출')
              ),
              SizedBox(height: 10),
              PopUp.popButton(context, '팝업버튼')
            ]
          )
        )
      ),
    );
  }
}