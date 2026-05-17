app.yaml

-------------------------------------------------------------
application: app
version: 1
runtime: python27
api_version: 1
threadsafe: no

handlers:
- url: /.*
  script: main.py

-------------------------------------------------------------

main.py

------------------------------------------------------------
#!/usr/bin/env python

import cgi

print "Content-Type: text/html"
print ""

form = cgi.FieldStorage()

if "a" in form and "b" in form:
    a = int(form["a"].value)
    b = int(form["b"].value)

    print "<h2>Addition =", a + b, "</h2>"
    print "<h2>Subtraction =", a - b, "</h2>"
    print "<h2>Multiplication =", a * b, "</h2>"

    if b != 0:
        print "<h2>Division =", float(a)/b, "</h2>"
    else:
        print "<h2>Division by zero not possible</h2>"

else:
    print """
    <html>
    <body>
    <form method="post">
        Number 1: <input type="text" name="a"><br><br>
        Number 2: <input type="text" name="b"><br><br>
        <input type="submit" value="Calculate">
    </form>
    </body>
    </html>
    """