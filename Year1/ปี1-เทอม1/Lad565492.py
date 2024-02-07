import mysql.connector
my_con = mysql.connector.connect(
    host="remotemysql.com",
    user="bPHiiRCWTe",
    passwd="Ftl2nnrmAp",
    database="bPHiiRCWTe"
)
print('connected!')
cursor = my_con.cursor()

print("[1.3]")
cursor.execute("SELECT * FROM characters WHERE animeFK='12'")
for x in cursor :
    print(x[0], x)

print("\n[1.4]")
try:
    cursor.execute("""INSERT INTO characters (id, fName, lName, popularity, animeFK) VALUES (504920, 'Boriphat', '_bbrpbbonus', 9999, 20)""")
    my_con.commit()
    print("INSERT SUCCESS")
except:
    print("INSERT ERROR")

print("\n[1.5]")
cursor.execute("SELECT * FROM characters INNER JOIN anime ON characters.animeFK = anime.id WHERE characters.id ='504920'")

for x in cursor :
    print(x[0], x)

cursor.close()
my_con.close() 