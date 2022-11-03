# REST API 설명
### 호스트 등록
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
|HttpMethod|URI|파라미터|
|------|---|---|
|Delete|/hosts/{name}|String name|

|처리결과|응답값|
|------|---|
|성공|{ "hostDelete": true }|
|실패|{ "hostDelete": false }|
##

### 호스트 alive 상태 체크
|HttpMethod|URI|파라미터|
|------|---|---|
|Patch|/statuses/{name}|String name|

|처리결과|응답값|
|------|---|
|성공|{ "aliveCheck": true }|
|실패|{ "aliveCheck": false }|
##

### 한 호스트 alive모니터링 결과 조회
|HttpMethod|URI|파라미터|
|------|---|---|
|Get|/statuses/{name}|String name|

|처리결과|응답값|
|------|---|
|성공|{ "name": ~ , "alive": ~ , "lastAliveTime": ~ }|
|실패|null|
##

### 전체 호스트 alive모니터링 결과 조회
|HttpMethod|URI|파라미터|
|------|---|---|
|Get|/statuses|null|

|처리결과|응답값|
|------|---|
|성공|[ { "name": ~ , "alive": ~ , "lastAliveTime": ~ }, ... , { "name": ~ , "alive": ~ , "lastAliveTime": ~ } ]|
##



|제목|내용|설명|
|------|---|---|
|테스트1|테스트2|테스트3|
|테스트1|테스트2|테스트3|
|테스트1|테스트2|테스트3|

