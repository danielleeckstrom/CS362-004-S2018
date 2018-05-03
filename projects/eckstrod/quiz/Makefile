CFLAGS = -Wall -fpic -coverage -lm
	
testme.o: testme.c 
	gcc -o testme -g testme.c $(CFLAGS)

	echo "testme.c:" >> testresults.out
	./testme >> testresults.out 2>&1
	gcov testme.c >> testresults.out
	cat testme.c.gcov >> testresults.out

clean:
	rm -f *.o *.gcov *.gcda *.gcno *.so *.out
