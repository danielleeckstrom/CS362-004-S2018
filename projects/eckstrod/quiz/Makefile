CFLAGS = -Wall -fpic -coverage -lm
	
testme.o: testme.c 
	gcc -o testme -g testme.c $(CFLAGS)
	./testme

clean:
	rm -f *.o *.gcov *.gcda *.gcno *.so *.out
