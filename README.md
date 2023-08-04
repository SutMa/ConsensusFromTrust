# ConsensusFromTrust
distributed consensus algorithm given a graph of "trust” relationships between nodes. This is an alternative method of resisting Sybil attacks and achieving consensus; it has the benefit of not “wasting” electricity like proof-of-work does.


The network is a directed random graph, where each edge represents a trust relationship. Forexample, if there is an A → B edge, it means that Node B listens to transactions broadcast by node A.
Each node will be given its list of followees via a boolean array whose indices correspond to nodes inthe graph. A ‘true’ at index i indicates that node i is a followee, ‘false’ otherwise. That node will alsobe given a list of transactions (its proposal list) that it can broadcast to its followers
