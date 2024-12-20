# REST API 설명
### 호스트 등록
두개의 테이블 host_list, host_status에서 각각 insert한다
|HttpMethod|URI|파라미터|
|------|---|---|
|Post|/hosts|String name, String ip|

|처리결과|응답값|
|------|---|
|성공|{ "registration": "success" }|
|실패|{ "registration": "failure" }|
|100명초과|{ "registration": "close" }|
##

### 호스트 조회
|HttpMethod|URI|파라미터|
|------|---|---|
|Get|/hosts/{name}|String name|

|처리결과|응답값|
|------|---|
|성공|{ "name": ~ , "ip": ~ , "createdAt": ~ , "updatedAt": ~ }|
|실패|null|
##

### 호스트 수정
|HttpMethod|URI|파라미터|
|------|---|---|
|Patch|/hosts/{name}|String name, String ip|

|처리결과|응답값|
|------|---|
|성공|{ "ipChange": true }|
|실패|{ "ipChange": false }|
##

### 호스트 삭제
두개의 테이블 host_list, host_status에서 각각 delete한다
|HttpMethod|URI|파라미터|
|------|---|---|
|Delete|/hosts/{name}|String name|

|처리결과|응답값|
|------|---|
|성공|{ "hostDelete": true }|
|실패|{ "hostDelete": false }|
##

### 한 호스트 alive 상태 체크
호스트의 alive를 체크하고나서, 그 결과를 테이블 host_status에 update한다   
테이블 host_status의 필드lastAliveTime의경우는 호스트가 alive할때만 now()로 업데이트 한다
|HttpMethod|URI|파라미터|
|------|---|---|
|Patch|/statuses/{name}|String name|

|처리결과|응답값|
|------|---|
|성공|{ "aliveCheck": true }|
|실패|{ "aliveCheck": false }|
##

### 한 호스트 alive모니터링 결과 조회
'한 호스트 alive 상태 체크api method'를 이용해서 현재 alive체크를 하고나서, 테이블 host_status에서 select한다  
|HttpMethod|URI|파라미터|
|------|---|---|
|Get|/statuses/{name}|String name|

|처리결과|응답값|
|------|---|
|성공|{ "name": ~ , "alive": ~ , "lastAliveTime": ~ }|
|실패|null|
##

### 전체 호스트 alive모니터링 결과 조회
클래스 StatusBO의 메소드 makeList()에 로직이 담겨있다 
|HttpMethod|URI|파라미터|
|------|---|---|
|Get|/statuses|null|

|처리결과|응답값|
|------|---|
|성공|[ { "name": ~ , "alive": ~ , "lastAliveTime": ~ }, ... , { "name": ~ , "alive": ~ , "lastAliveTime": ~ } ]|
##



