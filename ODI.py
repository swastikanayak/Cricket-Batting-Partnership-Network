# -*- coding: utf-8 -*-
#!/usr/bin/env python
#    Copyright (C) 2004-2015 by
#    Aric Hagberg <hagberg@lanl.gov>
#    Dan Schult <dschult@colgate.edu>
#    Pieter Swart <swart@lanl.gov>
#    All rights reserved.
#    BSD license.


#Code to find betweenness centrality, closeness centrality and assortativity coefficient of ODI networks
from networkx import *
from networkx.algorithms import community
import sys
from networkx.algorithms.community import greedy_modularity_communities
# H for unweighted, G for weighted
H=nx.read_edgelist("ODI_unweighted.txt")
G = nx.read_weighted_edgelist("ODI_weighted.csv", comments='#', delimiter=',', create_using=None, nodetype=None,encoding='utf-8')
#print(G.nodes())
#print(G.edges(data=True))
# some properties
#print(H.degree)
b = betweenness_centrality(H, k=None, normalized=False, weight=None, endpoints=False, seed=None)
print("Betweenness centrality:");
print(b);
print();
print();
print("Closeness centrality:");
c=closeness_centrality(H, u=None, distance=None)
print(c)
print();
print();
print("Assortativity coefficient:")
l = degree_pearson_correlation_coefficient(G, x='out', y='in', weight=None, nodes=None)
print(l)



