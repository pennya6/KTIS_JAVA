from flask import Flask, request

app = Flask(__name__)

@app.route('/sign-up', methods=['POST'])
def sign_up():
    data = request.form
    name = data.get('name')
    email = data.get('email')
    password = data.get('password')
    return f"User {name} with email {email} signed up!"

if __name__ == '__main__':
    app.run(debug=True)
