## HTTP protocol

HTTP 응답에 관하여 상세설명.
서버는 크게 클라이언트 서버(Client Server), 백엔드 서버(Backend Server/DBA Server 등)
그리고 우리가 하고있는 현 과정은 서버의 맨 앞에 public한 server로 이루어진
Client Server축에 속한다.
그중에서도 DB(Database) 의 분리를 시켜놓지 않은(실무에서는 대게 서버의 아티텍쳐를 설계하여 DB측을 분리해놓는다.)

현재 사용하고 있는 프로토콜은 1.1의 버전으로써, 간단하게 설명하자면 다음과 같다.

## BroadCast(브로드캐스트),Unicast(유니캐스트),Multicast(멀티캐스트), HTTP protocol 의 설명.

서버의 응답 프로토콜에서는 BroadCast -> UDP -> TCP/IP( and HTTP protocol) 순으로 발전해 왔다.

1. BroadCast(브로드캐스트)

-   설명하자면, 이장님이 안내방송을 하는것과 같다.
    000님 있으십니까? 하면 모든 사람들이 그 소리를 듣고 반응을 하는것과 같은 원리이다.
    컴퓨터는 고유 MAC 주소를 가지고 있다.(컴퓨터의 고유 이름이다.) 컴퓨터는 그 맥 주소로 다른 컴퓨터들을 판별하기 때문에  
    같은 네트워크안에 있는 컴퓨터 또는 컴퓨터'들'을 같이 한꺼번에 호출한다.
    따라서 다음과 같은 장단점이 있다.

### BroadCast 장단점

1. 장점
    - 빠르다. 같은 네트워크 권역 아래에 있는 컴퓨터를 맥주소를 알지않아도, ip주소를 알지 않다고 하더라도 전부 호출한다.
    - 모든 컴퓨터에 알람이나 하나의 컴퓨터에서 전체적인 컴퓨터에게 파일 전송할때 유리.
2. 단점 - 기본적으로 일 대 다(1:N) 관계로 이루어지기 때문에 N:O의 관계 즉 다수:다수 일 경우 컴퓨터에 부하가 많이 걸린다. - 모든 컴퓨터가 기본적으로 한번씩 반응하기때문에 효율적이지 못하다.
   브로드 캐스트 예시) 알람, Bluetooth(블루투스)

### Unicast(유니캐스트)

-   1대 1로 이루어지는 관계다. 간단히 설명하자면 A의 컴퓨터가 B의 컴퓨터에게 요청을 보낼때 서로의 ip주소와 서로의 mac주소를 주고받아서 학습한다.
    (너도 알고 나도 알고.)
    따라서 처음 보낼 때는 속도가 느리지만 한번 학습한 컴퓨터의 객체는 컴퓨터 메모리에 저장되므로 다음에 보내거나 받을때는 빠르다.

1. 장점

    - 1 대 1의 관계이므로 다른 컴퓨터에게 부하가 오지 않는다.
    - 처음 보낼때는 속도가 느리지만 메모리에 저장하고 기억하고 있으므로 다음부터 찾아가는데에는 어렵지 않다.

2. 단점.
    - 상대의 ip 주소를 알아야함.
    - 같은 네트워크 권역에 있어야함.
    - 상대적으로 브로드캐스트보다 속도가 느림.(1대 1의 관계에서 다수로 전송을 시도하려할때 부하가 걸린다.)
    - 파일전송을 시도하려할때 파일의 손실률이 높다.

### Multicast(멀티캐스트)

-   현재 네트워크 상에서 많이 사용되고 있는방식이다. 같은 네트워크 상에 있다는 전제하에 라우터라는 기기를 이용하여 물리적으로 네트워크 연결을 시켜놓으므로써
    하나의 네트워크 라는 개념이 생기게된 가장 큰 요소라고 할수 있다.

1. 장점
    - 1대 일 또는 다수로 데이터가 전송이 가능해졌다.
    - 물리적으로 연결되어있기에 속도가 빠르고 ip주소만 알면 라우터와 스위치가 알아서 주소를 알아내어 컴퓨터로 보내주니 편하다.
    - 상대적으로 먼거리도 전송이 가능함.
    - 많은 데이터를 한꺼번에 다수에게 뿌리게 될때, 라우터가 복사해서 뿌려주니 상대적으로 편함.
2. 단점
    - 비용(Cost)가 많이듦.
      -> 멀티캐스트를 지원하는 스위치와 라우터 등이 처음부터 끝까지 이어져야 하는데 하나라도 끊겨있으면 통신이 불가능해지므로 비용이 많이든다.
    - 라우터나 스위치가 꼭 필요하다는 제약이 있음.

## TCP/IP 통신, UDP 통신

### UDP통신

-   다이렉트형이다. 너가 받든지 말든지 나는 상관 안해. 라는 마인드이다. 데이터 손실율이 꽤 되는데 프로그램의 손실률이 따로 필요없는 매체나 음성쪽에 쓰인다.

1. 장점
    - 빠르다.
2. 단점 - 데이터를 받든지, 말든지 상관안하고 데이터 손실율도 상관을 안하고 다이렉트로 데이터를 꽂아버린다. - 데이터의 손실율이 크다. 음성같은경우 잡음이 생긴다.
   사용매체) TV 방송, 음성통화, 영상통화 등

## TCP/IP(Transmission Control Protocol/Internet Protocol)

-   내용이 너무 방대해서 따로 찾아보는것을 추천합니다. 과거 초기버전부터 이야기를 시작해야되기 때문입니다.
    하지만 여기서는 딱히 다루지는 않겠습니다. HTTP에 대해서는 필요가 없겠다고 판단했기 때문입니다.
    이부분은 따로 빼서 좀더 쉽고 짧고 간결하게 요약해서 나중에 공유드리도록 하겠습니다.
    혹시 알고 싶으신 분들이 있으시다면..(전공자 추천)
    `https://www.ibm.com/docs/ko/aix/7.1?topic=management-transmission-control-protocolinternet-protocol`
    한글+영문 문서.(IBM 국제문서 한글화 버전.) 참고.

### TCP/IP(Transmission Control Protocol/Internet Protocol) 中 HTTP 웹 요청

서버와 클라이언트 간에 요청/응답을 주고받을때 사용하는 규격이 HTTP와 HTTPS이다.
HTTPS는 인증된 url 만 사용이 가능한 서버이고, HTTP는 인증이 안된 구버전의 웹이라 비교적 취약하다.
그리고 웹포트는 기본적으로 80포트와 443포트를 갖고있다. 다음은 그 예시이다.

HTTP의 기본 맥락은 다음과 같다.
`http://www.google.com:80`

그리고 HTTPS의 맥락은 다음과 같다.
`https://www.google.com:443`

우리가 사용하는 URL은 전부 저 포트가 숨겨진 "정상적인" 접속이다.
만약 못믿겠다면 다른 목적을 가진 포트로 접속을 해보자.

`http://www.google.com:81`

`https://www.google.com:444`

그럼 이런 질문이 떠오를것이다. 왜 웹포트는 80의 규격을 따르고 있고 https조차 443의 포트를 따르고 있는것인가.

그 이유는 1999년 6월에 나온 RFC 2616에 나와있다.
http://www.rfc-editor.org/rfc/rfc2616.txt

```Text
3.2.2 http URL

   The "http" scheme is used to locate network resources via the HTTP
   protocol. This section defines the scheme-specific syntax and
   semantics for http URLs.

   http_URL = "http:" "//" host [ ":" port ] [ abs_path [ "?" query ]]

   If the port is empty or not given, port 80 is assumed. The semantics
   are that the identified resource is located at the server listening
   for TCP connections on that port of that host, and the Request-URI
   for the resource is abs_path (section 5.1.2). The use of IP addresses
   in URLs SHOULD be avoided whenever possible (see RFC 1900 [24]). If
   the abs_path is not present in the URL, it MUST be given as "/" when
   used as a Request-URI for a resource (section 5.1.2). If a proxy
   receives a host name which is not a fully qualified domain name, it
   MAY add its domain to the host name it received. If a proxy receives
   a fully qualified domain name, the proxy MUST NOT change the host
   name.
```

If the port is empty or not given, port 80 is assumed.
만약 포트가 비어있거나 없으면 포트는 무조건 80으로 간주한다.

이번에는 2015년도에 나온 RFC 7540(Hypertext Transfer Protocol Version2) version2(http/2) 를 보면 3절에 80, 443포트와 관련된 설명이 나와있다.

```Text
3.  Starting HTTP/2

   An HTTP/2 connection is an application-layer protocol running on top
   of a TCP connection ([TCP]).  The client is the TCP connection
   initiator.

   HTTP/2 uses the same "http" and "https" URI schemes used by HTTP/1.1.
   HTTP/2 shares the same default port numbers: 80 for "http" URIs and
   443 for "https" URIs.  As a result, implementations processing
   requests for target resource URIs like "http://example.org/foo" or
   "https://example.com/bar" are required to first discover whether the
   upstream server (the immediate peer to which the client wishes to
   establish a connection) supports HTTP/2.

   The means by which support for HTTP/2 is determined is different for
   "http" and "https" URIs.  Discovery for "http" URIs is described in
   Section 3.2.  Discovery for "https" URIs is described in Section 3.3.
```

Http protocol version 2를 쓸려고 하는 사람들한테 어떻게 해야 업그레이드된 규격에 맞춰 웹 서비스를 할수 있는지에 대해서 설명하고 있는 맥락이다.
`HTTP/2 shares the same default port numbers: 80 for "http" URIs and 443 for "https" URIs.`HTTP/2 는 동일한 기본 포트 넘버를 공유한다 : 80 은 HTTP uri 그리고 443 은 https uri
그 위의 맥락도 살펴보면
HTTP/2 use the same "http" and "https" URI schemes used by HTTP/1.1
HTTP/2는 HTTP/1.1에서 사용되는 것과 동일한 "http" 및 "https" URI 체계를 사용합니다.

따라서 이 맥락은
HTTP/2 는 http(1.1 버전) 에서 사용되는것과 동일한 http및 https uri 체계를 사용하며,
Http/2는 동일한 기본 포트 넘버를 사용한다. 80은 http의 uri 며 그리고 44감은 https url이다. 라고 번역할수 있다.

따라서 http의 기본 맥락은 바뀌지 않았다. 라는것을 알수있다.

그럼 왜 Why? 굳이 80 포트이며 443인가?

TCP/IP port process number 라고도 불리우는데
0~1023은 잘 알려진 포트이고
1024 ~ 49151번 등록된 포트
49152번 ~ 65535번 동적포트이다.

잘 알려진 포트에 대해서만 간단하게 짚고 넘어가도록 하겠다.
좀더 상세히 알고 싶다면 남긴 링크를 통해 확인하기를 권장한다.

이 TCP/UDP의 전송 프로토콜 port number 같은 경우에는
Unix(Linux 체제 전)에 미리 규약 된 경우가 대다수이므로 확인할때는 Linux 운영체제가 적합하다. 또한 Super user(root 권한) 을 가지지 않은 사용자는 엑세스를 할수 없으므로 root권한(관리자 권한)이 필요하다.

0 : UDP 지원 예약됨 사용하지않음.
1 : TCP 지원 TCPMUX(TCP포트 서비스 멀티플렉서)
7 : TCP,UDP 지원 ECHO(에코) 프로토콜
9 : TCP, UDP 지원 DISCARD 프로토콜(Service Kill)
13 : TCP, UDP 지원 DAYTIME 프로토콜
17 : TCP 지원 QOTD (Quote of the Day) 프로토콜

-----------여기서부터 중요(네트워크 시험에 무조건 나옴) --------------
19 : TCP, UDP CHARGEN (Charactor Generator) 프로토콜 - 원격 오류수정
20 : TCP 지원 파일전송 프로토콜 (FTP,File Transfer Protocol) - 데이터 포트
21 : TCP 지원 파일전송 프로토콜 (FTP, file Transfer Protocol) - 제어포트
22 : TCP 지원 시큐어 쉘 (SSH, Secure SHell) - ssh, scp, sftp같은 프로토콜 및 포트 포워딩.
23 : TCP 지원 텔넷 프로토콜(Telnet Protocol) - 암호화되지 않은 텍스트 통신
24 : TCP 지원 SMTP (Simple Mail Transfer Protocol) - E-Mail 전송에 사용

------------중요한 부분 끝---------------
중략.........

-----------알면 좋은 목록들.--------------

67 - 69 : UDP 지원 BOOTP(BOOTstrap Protocol)
67 - 서버. DHCP로도 사용
68 - 클라이언트. DHCP로도 사용.
69 - 간단한 파일전송 프로토콜 (TFTP Trivial File Transfer Protocol)

70 : TCP 지원 고퍼 프로토콜(Gopher Protocol)

80 : TCP, UDP 지원 HTTP(HyperText Transfer Protocol) - 웹 페이지 전송.
88 : TCP 지원 커베로스 - 인증에이전트
중략...
443 : TCP 지원 HTTPS - 보안 소켓 레이어 (SSL, Secure Socket Layer) 위의 HTTP의 암호화 전송.

자세한건 https://ko.wikipedia.org/wiki/TCP/UDP%EC%9D%98_%ED%8F%AC%ED%8A%B8_%EB%AA%A9%EB%A1%9D 여기 참조.

리눅스의 결과물과 증명을 보고싶다면
https://johngrib.github.io/wiki/why-http-80-https-443/
여기 참조.

여기까지 읽느라고 수고하셨고 다음에는 조금더 쉽게 찾아오도록 하겠습니다;;ㅋㅋ
