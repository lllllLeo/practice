print("Hello World!")

my_name = "김유준"

print(my_name)

print(my_name[0:2])

print(my_name[0:])
my_name = "레오 유준"
print(my_name.split())

# List 값을 변경할 수 있음. []
sake = ['하이볼', '맥주', '츄하이', '소주']
print(sake)
sake.append('양주')
print(sake)
print(len(sake))
sake.sort()
print(sake)

del sake[1]
print(sake)

# Tuple은 값을 변경할 수 없음, (), (괄호 안써도 알아서 소괄호가 들어감)

my_typle = ()
print(my_typle)
print(type(my_typle))

my_typle = 1, 2, 3
print(my_typle)


