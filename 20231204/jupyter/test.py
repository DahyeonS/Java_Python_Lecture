import  my_module

print(my_module.my_var)

my_class = my_module.My_class()
my_class.my_method()
my_module.my_def()

from my_module import My_class, my_var, my_def

print(my_var)
my_class = My_class()
my_class.my_method()
my_def()