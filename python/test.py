import requests

url = 'http://127.0.0.1:5000/sign-up'
data = {
    'name': '홍길동',
    'email': 'gildong@naver.com',
    'password': 'abcd1234'
}

response = requests.post(url, data=data)

print(response.status_code)
print(response.text)
