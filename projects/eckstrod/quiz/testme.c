#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<time.h>

char inputChar()
{
    // TODO: rewrite this function
	int randomASCII = rand() % (95) + 32; //random number between 32 ` ` and 126 `~`
	char input = randomASCII;
	
    return input;
}

char* inputString()
{
    // TODO: rewrite this function
	int i;
	char reset[6];
	char* input = reset;
	memset(reset, '\0', sizeof(reset));
	
	for(i=0; i < 5; i++)
	{
		//reset[i] = rand() % (16) + 101; //random number between 101 `e` and 116 `t`;//random number between 97 `a` and 122 `z`;
		reset[i] = rand() % (26) + 97; //random number between 97 `a` and 122 `z`;
		//reset[i] = inputChar();
		//reset[i] = rand() % (58) + 65; //random number between 65 `A` and 122 `z`;
	}
	
    return input;
}

void testme()
{
	clock_t startTime = clock(); 
	clock_t currentTime;
	double runtime = 0;
	int tcCount = 0;
	char *s;
	char c;
	int state = 0;
  
  while (runtime < 285) //285 seconds = 4.75 minutes
  {
    tcCount++;
    c = inputChar();
    s = inputString(); 
    printf("Iteration %d: c = %c, s = %s, state = %d\n", tcCount, c, s, state);

    if (c == '[' && state == 0) state = 1;
    if (c == '(' && state == 1) state = 2;
    if (c == '{' && state == 2) state = 3;
    if (c == ' '&& state == 3) state = 4;
    if (c == 'a' && state == 4) state = 5;
    if (c == 'x' && state == 5) state = 6;
    if (c == '}' && state == 6) state = 7;
    if (c == ')' && state == 7) state = 8;
    if (c == ']' && state == 8) state = 9;
    if (s[0] == 'r' && s[1] == 'e'
       && s[2] == 's' && s[3] == 'e'
       && s[4] == 't' && s[5] == '\0'
       && state == 9)
    {
      printf("error ");
      exit(200);
    }
	currentTime = clock();
	runtime = ((double)(currentTime - startTime) / CLOCKS_PER_SEC);
  }
  	printf("Runtime: %f\n", runtime);
}


int main(int argc, char *argv[])
{
    srand(time(NULL));
    testme();
    return 0;
}
