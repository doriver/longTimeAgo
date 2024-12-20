class User {
  String? name;
  int? age;
  String? profileImagePath;

  User({this.name, this.age, this.profileImagePath});

  User.genByMap(Map<String, dynamic> mapData) { // map데이터를 받아서 해당 데이터를 이용하여 User 클래스의 인스턴스를 생성
    name = mapData['name'];
    age = mapData['age'];
    profileImagePath = mapData['profileImagePath'];
  }
}