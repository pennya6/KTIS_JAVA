# request : http 요청가능

from flask import Flask, jsonify, request

# Flask 클래스를 객체화 시켜 app이라는 변수에 저장
app = Flask(__name__)
app.id_count=1
app.users={}

# ping 함수를 엔드포인트로 등록
@app.route("/ping", methods=['GET'])
def ping():
    return "pong"

#회원가입 test api
@app.route('/sign-up', methods=['POST'])
def sign_up():
    data = request.form
    name = data.get('name')
    email = data.get('email')
    password = data.get('password')
    return f"User {name} with email {email} signed up!"