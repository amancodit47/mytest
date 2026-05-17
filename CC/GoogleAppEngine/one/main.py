#!/usr/bin/env python
# -*- coding: utf-8 -*-

print 'Content-Type: text/html'
print ''

# Hello World
print '<h1>Hello World</h1>'

# Multiplication Table of 5
print '<h2>Multiplication Table of 5</h2>'
print '<pre>'
for x in range(1, 11):
    print '5 X %d = %d' % (x, 5 * x)
print '</pre>'

# Factorial
def factorial(n):
    result = 1
    for i in range(1, n + 1):
        result *= i
    return result

factorial_result = factorial(5)
print '<p><strong>Factorial of 5 is:</strong> %d</p>' % factorial_result

# Repeated User Details
name = 'Aman Kumar'
seat_number = '302'
department = 'IT'

print '<h2>User Details</h2>'
print '<pre>'
for _ in range(5):
    print 'Name: %s' % name
    print 'Seat Number: %s' % seat_number
    print 'Department: %s' % department
    print ''
print '</pre>'

# Fibonacci Series
def fibonacci(n):
    a, b = 0, 1
    result = []
    for _ in range(n):
        result.append(a)
        a, b = b, a + b
    return result

fib_result = fibonacci(5)
print '<p><strong>Fibonacci series up to 5 terms:</strong> %s</p>' % ' '.join(map(str, fib_result))

# Prime Numbers
def is_prime(n):
    if n <= 1:
        return False
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

print '<p><strong>Prime numbers from 1 to 5:</strong> ',
for i in range(1, 6):
    if is_prime(i):
        print '%d ' % i,
print '</p>'

# Armstrong Numbers
def is_armstrong(n):
    num_str = str(n)
    power = len(num_str)
    total = 0
    for d in num_str:
        total += int(d) ** power
    return total == n

print '<p><strong>Armstrong numbers from 1 to 500:</strong> ',
for i in range(1, 501):
    if is_armstrong(i):
        print '%d ' % i,
print '</p>'

# Theory Questions
print '<h2>Theory Questions</h2>'
print '<p><strong>1. What is Google App Engine (GAE)?</strong><br/>'
print 'GAE is a Platform-as-a-Service (PaaS) used to deploy web applications on Google infrastructure.</p>'

print '<p><strong>2. What is GAE Launcher?</strong><br/>'
print 'GAE Launcher is a GUI tool used to run and test GAE applications locally before deployment.</p>'

print '<p><strong>3. What is the role of app.yaml?</strong><br/>'
print 'app.yaml stores configuration settings like runtime, handlers, app ID, and environment parameters.</p>'
