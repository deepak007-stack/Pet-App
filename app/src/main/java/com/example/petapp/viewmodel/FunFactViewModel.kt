package com.example.petapp.viewmodel

import androidx.lifecycle.ViewModel

class FunFactViewModel : ViewModel() {

    fun generateFact(animalSelected: String): String {

        return if (animalSelected == "Cat") return catFact().random() else dogFact().random()
    }

    private fun dogFact(): List<String> {

        return listOf(
            "Happiness is a warm puppy",
            "The world would be a nicer place if everyone had the ability to love as unconditionally as a dog.",
            "Dogs are not our whole life, but they make our lives whole.",
            "A dog is the only thing on earth that loves you more than he loves himself.",
            "Dogs have a way of finding the people who need them and filling an emptiness we didn't ever know we had.",
            "The better I get to know men, the more I find myself loving dogs.",
            "Dogs do speak, but only to those who know how to listen.",
            "The greatest pleasure of a dog is that you may make a fool of yourself with him and not only will he not scold you, but he will make a fool of himself too.",
            "No matter how little money and how few possessions you own, having a dog makes you rich.",
            "Dogs' lives are too short. Their only fault, really."
        )
    }

    private fun catFact(): List<String> {
        return listOf(
            "Time spent with cats is never wasted.",
            "Cats choose us; we don't own them.",
            "I have studied many philosophers and many cats. The wisdom of cats is infinitely superior.",
            "In ancient times cats were worshipped as gods; they have not forgotten this.",
            "A cat has absolute emotional honesty: human beings, for one reason or another, may hide their feelings, but a cat does not.",
            "Cats are connoisseurs of comfort.",
            "The smallest feline is a masterpiece.",
            "There are few things in life more heartwarming than to be welcomed by a cat.",
            "A cat is a puzzle for which there is no solution.",
            "Cats are mysterious kind of folk - there is more passing in their minds than we are aware of.",
        )
    }
}