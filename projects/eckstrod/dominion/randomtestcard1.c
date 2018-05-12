#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <time.h>
#include "dominion.h"
#include "dominion_helpers.h"
#include "rngs.h"

#define TEST_COUNT 1000

//Custom Assert Function
void assertTrue(int a, int b, char* testName)
{
	if(a != b)
	{
		printf("%s Test Failed\n", testName);
	}
}

int main(int argc, char *argv[])
{
	//Print which test is being run
	printf("Random Test - Salvager");

	//Declare some variables
	srand(time(0));
	int t, i, r;
	
	for(t = 0; t < TEST_COUNT; t++)
	{	
		//Values to initiate game
		struct gameState state;	
		int numPlayers = rand() % 3 + 2; //random number between 2 and 4
		int kingdom[10];
	
		for(i = 0; i < 10; i++)
		{
			if (i == 0)
				kingdom[i] = salvager;
				
			else if(i == 1 && r == 0)
				kingdom[i] = curse;
			
			else if(i == 1 && r == 1)
				kingdom[i] = council_room;
				
			else if(i == 2 && r == 0)
				kingdom[i] = feast;
				
			else if(i == 2 && r == 1)
				kingdom[i] = gardens;
				
			else if(i == 3 && r == 0)
				kingdom[i] = mine;
			
			else if(i == 3 && r == 1)
				kingdom[i] = remodel;
				
			else if(i == 4 && r == 0)
				kingdom[i] = smithy;
				
			else if(i == 4 && r == 1)
				kingdom[i] = village;
				
			else if(i == 5 && r == 0)
				kingdom[i] = baron;
				
			else if(i == 5 && r == 1)
				kingdom[i] = great_hall;
				
			else if(i == 6 && r == 0)
				kingdom[i] = minion;
			
			else if(i == 6 && r == 1)
				kingdom[i] = steward;
			
			else if(i == 7 && r == 0)
				kingdom[i] = tribute;
				
			else if(i == 7 && r == 1)
				kingdom[i] = ambassador;
				
			else if(i == 8 && r == 0)
				kingdom[i] = cutpurse;
				
			else if(i == 8 && r == 1)
				kingdom[i] = embargo;
			
			else if(i == 9 && r == 0)
				kingdom[i] = outpost;
			
			else if(i == 9 && r == 1)
				kingdom[i] = adventurer;
				
			else if(i == 10 && r == 0)
				kingdom[i] = sea_hag;
				
			else if(i == 10 && r == 1)
				kingdom[i] = treasure_map;
				
			r = rand() % 2;
		}
		
		int seed = rand(); //random number	
  
		//Initiate Game
		int initSuccess = initializeGame(numPlayers, kingdom, seed, &state);
		if(initSuccess != 0)
		{
		   printf("Game failed to initialize\n");
		}
		
		for(i = 0; i < numPlayers; i++)
		{
			//State of Game Before Card is Played
			int player = whoseTurn(&state);
			int bonus = rand();
			int choice1, choice2, choice3;
			
			if(rand() % 2)
			{
				choice1 = 0;
			}
				
			else
			{
				choice1 = kingdom[(rand() % 10)]; //get a random kingdom card
			}
			
			if(rand() % 2)
			{
				choice2 = 0;
			}
			
			else
			{
				choice2 = kingdom[(rand() % 10)]; //get a random kingdom card
			}
			
			if(rand() % 2)
			{
				choice3 = 0;
			}
			
			else
			{
				choice3 = kingdom[(rand() % 10)]; //get a random kingdom card
			}
	
			state.deckCount[player] = rand() % (MAX_DECK + 1);
			state.discardCount[player] = rand() % (MAX_DECK - state.deckCount[player] + 1);
			int fullDeckSizeBefore = state.deckCount[player] + state.handCount[player] + state.discardCount[player] + state.playedCardCount; 
			
			int numBuys = rand() % 3 + 1;
			state.numBuys = numBuys;
			
			int moneyToSpend = rand() % 7;
			state.coins = moneyToSpend;			
			int handpos = rand() % numHandCards(&state); //random hand position
			
			int valueChoice = getCost(handCard(choice1, &state));
	
			//Play Salvager
			cardEffect(salvager, choice1, choice2, choice3, &state, handpos, &bonus);
		   
			//State of Game After Salvager is Played
			int fullDeckSizeAfter = state.deckCount[player] + state.handCount[player] + state.discardCount[player] + state.playedCardCount;
		   
			//Test Correct Number of Buys Remaining
			assertTrue(numBuys + 1, state.numBuys, "Correct Number of Buys Remaining -");
				
			if(choice1)
			{	
				//Test Correct Full Deck Size - One Card Should be Trashed
				assertTrue(fullDeckSizeBefore - 1, fullDeckSizeAfter, "Correct Full Deck Size -");
				
				//Test Correct Amount Money to Spend - Additional $ Should be Available 
				assertTrue(moneyToSpend + valueChoice, state.coins, "Correct Amount Money to Spend -");
			}
			
			else
			{
				//Test Correct Deck Size - Should Remain Unchanged
				assertTrue(fullDeckSizeBefore, fullDeckSizeAfter, "Correct Full Deck Size -");
				
				//Test Correct Amount Money to Spend - Should Remain Unchanged
				assertTrue(moneyToSpend, state.coins, "Correct Amount Money to Spend -");
			}
			
			//Advance to a new players turn
			endTurn(&state);
		}
	}
	
	return 0;   
}


