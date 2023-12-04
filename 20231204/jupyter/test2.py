import my_package.my_module2

print(my_package.my_module2.my_var)
my_class = my_package.my_module2.My_class()
my_class.my_method()
my_package.my_module2.my_def()

from my_package import my_module2

print(my_module2.my_var)
my_class = my_module2.My_class()
my_class.my_method()
my_module2.my_def()

from my_package.my_module2 import my_var, My_class, my_def

print(my_var)
my_class = My_class()
my_class.my_method()
my_def()

import my_package.my_module2 as mm

print(mm.my_var)
my_class = mm.My_class()
my_class.my_method()
mm.my_def()